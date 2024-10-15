package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnSwapLeg;
import fpml.confirmation.validation.ReturnSwapLegTypeFormatValidator;
import fpml.confirmation.validation.ReturnSwapLegValidator;
import fpml.confirmation.validation.exists.ReturnSwapLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReturnSwapLeg.class)
public class ReturnSwapLegMeta implements RosettaMetaData<ReturnSwapLeg> {

	@Override
	public List<Validator<? super ReturnSwapLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnSwapLeg> validator() {
		return new ReturnSwapLegValidator();
	}

	@Override
	public Validator<? super ReturnSwapLeg> typeFormatValidator() {
		return new ReturnSwapLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapLeg, Set<String>> onlyExistsValidator() {
		return new ReturnSwapLegOnlyExistsValidator();
	}
}
