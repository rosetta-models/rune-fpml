package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.SettlementInformation;
import fpml.confirmation.validation.SettlementInformationTypeFormatValidator;
import fpml.confirmation.validation.SettlementInformationValidator;
import fpml.confirmation.validation.exists.SettlementInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=SettlementInformation.class)
public class SettlementInformationMeta implements RosettaMetaData<SettlementInformation> {

	@Override
	public List<Validator<? super SettlementInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.SettlementInformation>create(fpml.confirmation.validation.datarule.SettlementInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super SettlementInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super SettlementInformation> validator() {
		return new SettlementInformationValidator();
	}

	@Override
	public Validator<? super SettlementInformation> typeFormatValidator() {
		return new SettlementInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super SettlementInformation, Set<String>> onlyExistsValidator() {
		return new SettlementInformationOnlyExistsValidator();
	}
}
