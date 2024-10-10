package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityDeliverySystemFirm;
import fpml.confirmation.validation.ElectricityDeliverySystemFirmTypeFormatValidator;
import fpml.confirmation.validation.ElectricityDeliverySystemFirmValidator;
import fpml.confirmation.validation.exists.ElectricityDeliverySystemFirmOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ElectricityDeliverySystemFirm.class)
public class ElectricityDeliverySystemFirmMeta implements RosettaMetaData<ElectricityDeliverySystemFirm> {

	@Override
	public List<Validator<? super ElectricityDeliverySystemFirm>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityDeliverySystemFirm, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityDeliverySystemFirm> validator() {
		return new ElectricityDeliverySystemFirmValidator();
	}

	@Override
	public Validator<? super ElectricityDeliverySystemFirm> typeFormatValidator() {
		return new ElectricityDeliverySystemFirmTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityDeliverySystemFirm, Set<String>> onlyExistsValidator() {
		return new ElectricityDeliverySystemFirmOnlyExistsValidator();
	}
}
