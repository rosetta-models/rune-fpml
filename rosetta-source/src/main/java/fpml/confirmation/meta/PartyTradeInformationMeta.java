package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.PartyTradeInformation;
import fpml.confirmation.validation.PartyTradeInformationTypeFormatValidator;
import fpml.confirmation.validation.PartyTradeInformationValidator;
import fpml.confirmation.validation.exists.PartyTradeInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=PartyTradeInformation.class)
public class PartyTradeInformationMeta implements RosettaMetaData<PartyTradeInformation> {

	@Override
	public List<Validator<? super PartyTradeInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.PartyTradeInformation>create(fpml.confirmation.validation.datarule.PartyTradeInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super PartyTradeInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super PartyTradeInformation> validator() {
		return new PartyTradeInformationValidator();
	}

	@Override
	public Validator<? super PartyTradeInformation> typeFormatValidator() {
		return new PartyTradeInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super PartyTradeInformation, Set<String>> onlyExistsValidator() {
		return new PartyTradeInformationOnlyExistsValidator();
	}
}
