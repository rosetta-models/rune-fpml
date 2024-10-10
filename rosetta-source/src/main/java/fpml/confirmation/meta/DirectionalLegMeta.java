package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.DirectionalLeg;
import fpml.confirmation.validation.DirectionalLegTypeFormatValidator;
import fpml.confirmation.validation.DirectionalLegValidator;
import fpml.confirmation.validation.exists.DirectionalLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=DirectionalLeg.class)
public class DirectionalLegMeta implements RosettaMetaData<DirectionalLeg> {

	@Override
	public List<Validator<? super DirectionalLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super DirectionalLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super DirectionalLeg> validator() {
		return new DirectionalLegValidator();
	}

	@Override
	public Validator<? super DirectionalLeg> typeFormatValidator() {
		return new DirectionalLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super DirectionalLeg, Set<String>> onlyExistsValidator() {
		return new DirectionalLegOnlyExistsValidator();
	}
}
