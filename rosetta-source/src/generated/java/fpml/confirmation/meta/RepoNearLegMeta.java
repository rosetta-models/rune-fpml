package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RepoNearLeg;
import fpml.confirmation.validation.RepoNearLegTypeFormatValidator;
import fpml.confirmation.validation.RepoNearLegValidator;
import fpml.confirmation.validation.exists.RepoNearLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RepoNearLeg.class)
public class RepoNearLegMeta implements RosettaMetaData<RepoNearLeg> {

	@Override
	public List<Validator<? super RepoNearLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepoNearLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RepoNearLeg> validator() {
		return new RepoNearLegValidator();
	}

	@Override
	public Validator<? super RepoNearLeg> typeFormatValidator() {
		return new RepoNearLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepoNearLeg, Set<String>> onlyExistsValidator() {
		return new RepoNearLegOnlyExistsValidator();
	}
}
