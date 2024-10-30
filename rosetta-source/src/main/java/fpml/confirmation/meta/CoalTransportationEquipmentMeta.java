package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalTransportationEquipment;
import fpml.confirmation.validation.CoalTransportationEquipmentTypeFormatValidator;
import fpml.confirmation.validation.CoalTransportationEquipmentValidator;
import fpml.confirmation.validation.exists.CoalTransportationEquipmentOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalTransportationEquipment.class)
public class CoalTransportationEquipmentMeta implements RosettaMetaData<CoalTransportationEquipment> {

	@Override
	public List<Validator<? super CoalTransportationEquipment>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super CoalTransportationEquipment, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalTransportationEquipment> validator() {
		return new CoalTransportationEquipmentValidator();
	}

	@Override
	public Validator<? super CoalTransportationEquipment> typeFormatValidator() {
		return new CoalTransportationEquipmentTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalTransportationEquipment, Set<String>> onlyExistsValidator() {
		return new CoalTransportationEquipmentOnlyExistsValidator();
	}
}
