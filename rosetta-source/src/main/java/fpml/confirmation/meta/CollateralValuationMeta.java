package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CollateralValuation;
import fpml.confirmation.validation.CollateralValuationTypeFormatValidator;
import fpml.confirmation.validation.CollateralValuationValidator;
import fpml.confirmation.validation.exists.CollateralValuationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=CollateralValuation.class)
public class CollateralValuationMeta implements RosettaMetaData<CollateralValuation> {

	@Override
	public List<Validator<? super CollateralValuation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CollateralValuation>create(fpml.confirmation.validation.datarule.CollateralValuationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CollateralValuation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CollateralValuation> validator() {
		return new CollateralValuationValidator();
	}

	@Override
	public Validator<? super CollateralValuation> typeFormatValidator() {
		return new CollateralValuationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CollateralValuation, Set<String>> onlyExistsValidator() {
		return new CollateralValuationOnlyExistsValidator();
	}
}
