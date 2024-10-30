package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeReferenceInformationUpdateException;
import fpml.confirmation.validation.TradeReferenceInformationUpdateExceptionTypeFormatValidator;
import fpml.confirmation.validation.TradeReferenceInformationUpdateExceptionValidator;
import fpml.confirmation.validation.exists.TradeReferenceInformationUpdateExceptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=TradeReferenceInformationUpdateException.class)
public class TradeReferenceInformationUpdateExceptionMeta implements RosettaMetaData<TradeReferenceInformationUpdateException> {

	@Override
	public List<Validator<? super TradeReferenceInformationUpdateException>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeReferenceInformationUpdateException, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeReferenceInformationUpdateException> validator() {
		return new TradeReferenceInformationUpdateExceptionValidator();
	}

	@Override
	public Validator<? super TradeReferenceInformationUpdateException> typeFormatValidator() {
		return new TradeReferenceInformationUpdateExceptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeReferenceInformationUpdateException, Set<String>> onlyExistsValidator() {
		return new TradeReferenceInformationUpdateExceptionOnlyExistsValidator();
	}
}
