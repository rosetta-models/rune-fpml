package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDeliveryType;
import fpml.confirmation.validation.ElectricityDeliveryTypeTypeFormatValidator;
import fpml.confirmation.validation.ElectricityDeliveryTypeValidator;
import fpml.confirmation.validation.exists.ElectricityDeliveryTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ElectricityDeliveryType.class)
public class ElectricityDeliveryTypeMeta implements RosettaMetaData<ElectricityDeliveryType> {

	@Override
	public List<Validator<? super ElectricityDeliveryType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ElectricityDeliveryType>create(fpml.confirmation.validation.datarule.ElectricityDeliveryTypeChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliveryType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityDeliveryType> validator() {
		return new ElectricityDeliveryTypeValidator();
	}

	@Override
	public Validator<? super ElectricityDeliveryType> typeFormatValidator() {
		return new ElectricityDeliveryTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliveryType, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryTypeOnlyExistsValidator();
	}
}
