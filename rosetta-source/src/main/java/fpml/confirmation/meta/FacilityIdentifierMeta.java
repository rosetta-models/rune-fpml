package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FacilityIdentifier;
import fpml.confirmation.validation.FacilityIdentifierTypeFormatValidator;
import fpml.confirmation.validation.FacilityIdentifierValidator;
import fpml.confirmation.validation.exists.FacilityIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FacilityIdentifier.class)
public class FacilityIdentifierMeta implements RosettaMetaData<FacilityIdentifier> {

	@Override
	public List<Validator<? super FacilityIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super FacilityIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FacilityIdentifier> validator() {
		return new FacilityIdentifierValidator();
	}

	@Override
	public Validator<? super FacilityIdentifier> typeFormatValidator() {
		return new FacilityIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FacilityIdentifier, Set<String>> onlyExistsValidator() {
		return new FacilityIdentifierOnlyExistsValidator();
	}
}
