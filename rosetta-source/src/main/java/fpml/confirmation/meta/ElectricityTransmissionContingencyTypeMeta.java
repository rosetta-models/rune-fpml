package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityTransmissionContingencyType;
import fpml.confirmation.validation.ElectricityTransmissionContingencyTypeTypeFormatValidator;
import fpml.confirmation.validation.ElectricityTransmissionContingencyTypeValidator;
import fpml.confirmation.validation.exists.ElectricityTransmissionContingencyTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ElectricityTransmissionContingencyType.class)
public class ElectricityTransmissionContingencyTypeMeta implements RosettaMetaData<ElectricityTransmissionContingencyType> {

	@Override
	public List<Validator<? super ElectricityTransmissionContingencyType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityTransmissionContingencyType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityTransmissionContingencyType> validator() {
		return new ElectricityTransmissionContingencyTypeValidator();
	}

	@Override
	public Validator<? super ElectricityTransmissionContingencyType> typeFormatValidator() {
		return new ElectricityTransmissionContingencyTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityTransmissionContingencyType, Set<String>> onlyExistsValidator() {
		return new ElectricityTransmissionContingencyTypeOnlyExistsValidator();
	}
}
