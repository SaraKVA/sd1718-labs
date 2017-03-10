/*
 * This is sample code generated by rpcgen.
 * These are only templates and you can use them
 * as a guideline for developing your own functions.
 */

#include "ttt.h"
#include "ttt_lib.h"

char **
currentboard_1_svc(void *argp, struct svc_req *rqstp)
{
    static char *result = NULL;
    result = malloc(MAX_BUFFER_LEN);
    currentBoard(result);

    return &result;
}

int *
play_1_svc(play_args *argp, struct svc_req *rqstp)
{
  static int  result;

  result = play(argp->row, argp->column, argp->player);
  
  return &result;
}

int *
checkwinner_1_svc(void *argp, struct svc_req *rqstp)
{
  static int  result;

  result = checkWinner();

  return &result;
}


play_args* 
ultima_1_svc(void *argp, struct svc_req *rqstp){
        
    static play_args result;
       
    result = ultima();
    
    printf("%d %d %d\n", result.row, result.column, result.player);
    
    return &result;
    
}
