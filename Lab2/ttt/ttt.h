/*
 * Please do not edit this file.
 * It was generated using rpcgen.
 */

#ifndef _TTT_H_RPCGEN
#define _TTT_H_RPCGEN

#include <rpc/rpc.h>


#ifdef __cplusplus
extern "C" {
#endif


struct play_args {
	int row;
	int column;
	int player;
};
typedef struct play_args play_args;

#define TTT 0x31478982
#define V1 1

#if defined(__STDC__) || defined(__cplusplus)
#define CURRENTBOARD 1
extern  char ** currentboard_1(void *, CLIENT *);
extern  char ** currentboard_1_svc(void *, struct svc_req *);
#define PLAY 2
extern  int * play_1(play_args *, CLIENT *);
extern  int * play_1_svc(play_args *, struct svc_req *);
#define CHECKWINNER 3
extern  int * checkwinner_1(void *, CLIENT *);
extern  int * checkwinner_1_svc(void *, struct svc_req *);
extern int ttt_1_freeresult (SVCXPRT *, xdrproc_t, caddr_t);

#else /* K&R C */
#define CURRENTBOARD 1
extern  char ** currentboard_1();
extern  char ** currentboard_1_svc();
#define PLAY 2
extern  int * play_1();
extern  int * play_1_svc();
#define CHECKWINNER 3
extern  int * checkwinner_1();
extern  int * checkwinner_1_svc();
extern int ttt_1_freeresult ();
#endif /* K&R C */

/* the xdr functions */

#if defined(__STDC__) || defined(__cplusplus)
extern  bool_t xdr_play_args (XDR *, play_args*);

#else /* K&R C */
extern bool_t xdr_play_args ();

#endif /* K&R C */

#ifdef __cplusplus
}
#endif

#endif /* !_TTT_H_RPCGEN */