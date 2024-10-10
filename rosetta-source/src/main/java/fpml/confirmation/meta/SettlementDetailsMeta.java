package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementDetails;
import fpml.confirmation.validation.SettlementDetailsTypeFormatValidator;
import fpml.confirmation.validation.SettlementDetailsValidator;
import fpml.confirmation.validation.exists.SettlementDetailsOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=SettlementDetails.class)
public class SettlementDetailsMeta implements RosettaMetaData<SettlementDetails> {

	@Override
	public List<Validator<? super SettlementDetails>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super SettlementDetails, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementDetails> validator() {
		return new SettlementDetailsValidator();
	}

	@Override
	public Validator<? super SettlementDetails> typeFormatValidator() {
		return new SettlementDetailsTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementDetails, Set<String>> onlyExistsValidator() {
		return new SettlementDetailsOnlyExistsValidator();
	}
}
