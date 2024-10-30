package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ElectricityTransmissionContingency;
import fpml.confirmation.validation.ElectricityTransmissionContingencyTypeFormatValidator;
import fpml.confirmation.validation.ElectricityTransmissionContingencyValidator;
import fpml.confirmation.validation.exists.ElectricityTransmissionContingencyOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ElectricityTransmissionContingency.class)
public class ElectricityTransmissionContingencyMeta implements RosettaMetaData<ElectricityTransmissionContingency> {

	@Override
	public List<Validator<? super ElectricityTransmissionContingency>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ElectricityTransmissionContingency, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ElectricityTransmissionContingency> validator() {
		return new ElectricityTransmissionContingencyValidator();
	}

	@Override
	public Validator<? super ElectricityTransmissionContingency> typeFormatValidator() {
		return new ElectricityTransmissionContingencyTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ElectricityTransmissionContingency, Set<String>> onlyExistsValidator() {
		return new ElectricityTransmissionContingencyOnlyExistsValidator();
	}
}
