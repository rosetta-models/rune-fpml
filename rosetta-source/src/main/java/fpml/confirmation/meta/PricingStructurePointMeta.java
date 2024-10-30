package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingStructurePoint;
import fpml.confirmation.validation.PricingStructurePointTypeFormatValidator;
import fpml.confirmation.validation.PricingStructurePointValidator;
import fpml.confirmation.validation.exists.PricingStructurePointOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=PricingStructurePoint.class)
public class PricingStructurePointMeta implements RosettaMetaData<PricingStructurePoint> {

	@Override
	public List<Validator<? super PricingStructurePoint>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingStructurePoint, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingStructurePoint> validator() {
		return new PricingStructurePointValidator();
	}

	@Override
	public Validator<? super PricingStructurePoint> typeFormatValidator() {
		return new PricingStructurePointTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingStructurePoint, Set<String>> onlyExistsValidator() {
		return new PricingStructurePointOnlyExistsValidator();
	}
}
