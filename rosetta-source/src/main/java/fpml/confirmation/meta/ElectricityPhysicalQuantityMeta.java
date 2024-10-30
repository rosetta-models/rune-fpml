package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityPhysicalQuantity;
import fpml.confirmation.validation.ElectricityPhysicalQuantityTypeFormatValidator;
import fpml.confirmation.validation.ElectricityPhysicalQuantityValidator;
import fpml.confirmation.validation.exists.ElectricityPhysicalQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ElectricityPhysicalQuantity.class)
public class ElectricityPhysicalQuantityMeta implements RosettaMetaData<ElectricityPhysicalQuantity> {

	@Override
	public List<Validator<? super ElectricityPhysicalQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ElectricityPhysicalQuantity>create(fpml.confirmation.validation.datarule.ElectricityPhysicalQuantityChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ElectricityPhysicalQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityPhysicalQuantity> validator() {
		return new ElectricityPhysicalQuantityValidator();
	}

	@Override
	public Validator<? super ElectricityPhysicalQuantity> typeFormatValidator() {
		return new ElectricityPhysicalQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityPhysicalQuantity, Set<String>> onlyExistsValidator() {
		return new ElectricityPhysicalQuantityOnlyExistsValidator();
	}
}
