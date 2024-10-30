package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.MoneyWithParticipantShare;
import fpml.confirmation.validation.MoneyWithParticipantShareTypeFormatValidator;
import fpml.confirmation.validation.MoneyWithParticipantShareValidator;
import fpml.confirmation.validation.exists.MoneyWithParticipantShareOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=MoneyWithParticipantShare.class)
public class MoneyWithParticipantShareMeta implements RosettaMetaData<MoneyWithParticipantShare> {

	@Override
	public List<Validator<? super MoneyWithParticipantShare>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super MoneyWithParticipantShare, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super MoneyWithParticipantShare> validator() {
		return new MoneyWithParticipantShareValidator();
	}

	@Override
	public Validator<? super MoneyWithParticipantShare> typeFormatValidator() {
		return new MoneyWithParticipantShareTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super MoneyWithParticipantShare, Set<String>> onlyExistsValidator() {
		return new MoneyWithParticipantShareOnlyExistsValidator();
	}
}
