package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDeliveryFirm;
import fpml.confirmation.validation.ElectricityDeliveryFirmTypeFormatValidator;
import fpml.confirmation.validation.ElectricityDeliveryFirmValidator;
import fpml.confirmation.validation.exists.ElectricityDeliveryFirmOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ElectricityDeliveryFirm.class)
public class ElectricityDeliveryFirmMeta implements RosettaMetaData<ElectricityDeliveryFirm> {

	@Override
	public List<Validator<? super ElectricityDeliveryFirm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliveryFirm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityDeliveryFirm> validator() {
		return new ElectricityDeliveryFirmValidator();
	}

	@Override
	public Validator<? super ElectricityDeliveryFirm> typeFormatValidator() {
		return new ElectricityDeliveryFirmTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliveryFirm, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliveryFirmOnlyExistsValidator();
	}
}
