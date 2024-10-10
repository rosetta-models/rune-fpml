package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PricingStructure;
import fpml.confirmation.validation.PricingStructureTypeFormatValidator;
import fpml.confirmation.validation.PricingStructureValidator;
import fpml.confirmation.validation.exists.PricingStructureOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PricingStructure.class)
public class PricingStructureMeta implements RosettaMetaData<PricingStructure> {

	@Override
	public List<Validator<? super PricingStructure>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super PricingStructure, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PricingStructure> validator() {
		return new PricingStructureValidator();
	}

	@Override
	public Validator<? super PricingStructure> typeFormatValidator() {
		return new PricingStructureTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PricingStructure, Set<String>> onlyExistsValidator() {
		return new PricingStructureOnlyExistsValidator();
	}
}
