package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeReferenceInformation;
import fpml.confirmation.validation.TradeReferenceInformationTypeFormatValidator;
import fpml.confirmation.validation.TradeReferenceInformationValidator;
import fpml.confirmation.validation.exists.TradeReferenceInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeReferenceInformation.class)
public class TradeReferenceInformationMeta implements RosettaMetaData<TradeReferenceInformation> {

	@Override
	public List<Validator<? super TradeReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.TradeReferenceInformation>create(fpml.confirmation.validation.datarule.TradeReferenceInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super TradeReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeReferenceInformation> validator() {
		return new TradeReferenceInformationValidator();
	}

	@Override
	public Validator<? super TradeReferenceInformation> typeFormatValidator() {
		return new TradeReferenceInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeReferenceInformation, Set<String>> onlyExistsValidator() {
		return new TradeReferenceInformationOnlyExistsValidator();
	}
}
