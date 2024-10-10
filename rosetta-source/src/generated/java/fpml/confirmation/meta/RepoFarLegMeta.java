package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RepoFarLeg;
import fpml.confirmation.validation.RepoFarLegTypeFormatValidator;
import fpml.confirmation.validation.RepoFarLegValidator;
import fpml.confirmation.validation.exists.RepoFarLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=RepoFarLeg.class)
public class RepoFarLegMeta implements RosettaMetaData<RepoFarLeg> {

	@Override
	public List<Validator<? super RepoFarLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RepoFarLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RepoFarLeg> validator() {
		return new RepoFarLegValidator();
	}

	@Override
	public Validator<? super RepoFarLeg> typeFormatValidator() {
		return new RepoFarLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RepoFarLeg, Set<String>> onlyExistsValidator() {
		return new RepoFarLegOnlyExistsValidator();
	}
}
