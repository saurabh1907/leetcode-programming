def mergeStrings(s1, s2):
    freq_s1 = {}
    freq_s2 = {}
    for c in s1:
        if c in freq_s1:
            freq_s1[c] +=1
        else:
            freq_s1[c] = 1
    for c in s2:
        if c in freq_s2:
            freq_s2[c] +=1
        else:
            freq_s2[c] = 1

    i=0
    j=0
    final = ""
    while i< len(s1) and j< len(s2) :
        if i< len(s1) and freq_s1[s1[i]] < freq_s2[s2[j]]:
            final += s1[i]
            i +=1

        elif j< len(s2) and freq_s1[s1[i]] > freq_s2[s2[j]]:

            final += s2[j]
            j +=1

        else:
            if i< len(s1) and s1[i] < s2[j]:
                final += s1[i]
                i +=1

            elif j< len(s2) and s1[i] > s2[j]:
                final += s2[j]
                j +=1

            else:
                final += s1[i]
                i +=1

    if i< len(s1):
        final = final + s1[i:]
    if j< len(s2):
        final = final + s2[j:]
    return final



mergeStrings("super", "tower")