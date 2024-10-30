package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityPhysicalDeliveryQuantity;
import fpml.confirmation.validation.ElectricityPhysicalDeliveryQuantityTypeFormatValidator;
import fpml.confirmation.validation.ElectricityPhysicalDeliveryQuantityValidator;
import fpml.confirmation.validation.exists.ElectricityPhysicalDeliveryQuantityOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ElectricityPhysicalDeliveryQuantity.class)
public class ElectricityPhysicalDeliveryQuantityMeta implements RosettaMetaData<ElectricityPhysicalDeliveryQuantity> {

	@Override
	public List<Validator<? super ElectricityPhysicalDeliveryQuantity>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityPhysicalDeliveryQuantity, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantity> validator() {
		return new ElectricityPhysicalDeliveryQuantityValidator();
	}

	@Override
	public Validator<? super ElectricityPhysicalDeliveryQuantity> typeFormatValidator() {
		return new ElectricityPhysicalDeliveryQuantityTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityPhysicalDeliveryQuantity, Set<String>> onlyExistsValidator() {
		return new ElectricityPhysicalDeliveryQuantityOnlyExistsValidator();
	}
}
