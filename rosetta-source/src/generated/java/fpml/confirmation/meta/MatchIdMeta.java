package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MatchId;
import fpml.confirmation.validation.MatchIdTypeFormatValidator;
import fpml.confirmation.validation.MatchIdValidator;
import fpml.confirmation.validation.exists.MatchIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=MatchId.class)
public class MatchIdMeta implements RosettaMetaData<MatchId> {

	@Override
	public List<Validator<? super MatchId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MatchId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MatchId> validator() {
		return new MatchIdValidator();
	}

	@Override
	public Validator<? super MatchId> typeFormatValidator() {
		return new MatchIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MatchId, Set<String>> onlyExistsValidator() {
		return new MatchIdOnlyExistsValidator();
	}
}
