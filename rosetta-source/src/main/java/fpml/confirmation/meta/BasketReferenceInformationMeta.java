package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasketReferenceInformation;
import fpml.confirmation.validation.BasketReferenceInformationTypeFormatValidator;
import fpml.confirmation.validation.BasketReferenceInformationValidator;
import fpml.confirmation.validation.exists.BasketReferenceInformationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=BasketReferenceInformation.class)
public class BasketReferenceInformationMeta implements RosettaMetaData<BasketReferenceInformation> {

	@Override
	public List<Validator<? super BasketReferenceInformation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.BasketReferenceInformation>create(fpml.confirmation.validation.datarule.BasketReferenceInformationChoice.class)
		);
	}
	
	@Override
	public List<Function<? super BasketReferenceInformation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasketReferenceInformation> validator() {
		return new BasketReferenceInformationValidator();
	}

	@Override
	public Validator<? super BasketReferenceInformation> typeFormatValidator() {
		return new BasketReferenceInformationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasketReferenceInformation, Set<String>> onlyExistsValidator() {
		return new BasketReferenceInformationOnlyExistsValidator();
	}
}
