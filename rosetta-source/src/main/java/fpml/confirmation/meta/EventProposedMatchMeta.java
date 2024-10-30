package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.EventProposedMatch;
import fpml.confirmation.validation.EventProposedMatchTypeFormatValidator;
import fpml.confirmation.validation.EventProposedMatchValidator;
import fpml.confirmation.validation.exists.EventProposedMatchOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=EventProposedMatch.class)
public class EventProposedMatchMeta implements RosettaMetaData<EventProposedMatch> {

	@Override
	public List<Validator<? super EventProposedMatch>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.EventProposedMatch>create(fpml.confirmation.validation.datarule.EventProposedMatchChoice.class)
		);
	}
	
	@Override
	public List<Function<? super EventProposedMatch, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super EventProposedMatch> validator() {
		return new EventProposedMatchValidator();
	}

	@Override
	public Validator<? super EventProposedMatch> typeFormatValidator() {
		return new EventProposedMatchTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super EventProposedMatch, Set<String>> onlyExistsValidator() {
		return new EventProposedMatchOnlyExistsValidator();
	}
}
