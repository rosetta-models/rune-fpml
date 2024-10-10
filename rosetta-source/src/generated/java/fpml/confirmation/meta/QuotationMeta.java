package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.Quotation;
import fpml.confirmation.validation.QuotationTypeFormatValidator;
import fpml.confirmation.validation.QuotationValidator;
import fpml.confirmation.validation.exists.QuotationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=Quotation.class)
public class QuotationMeta implements RosettaMetaData<Quotation> {

	@Override
	public List<Validator<? super Quotation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super Quotation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super Quotation> validator() {
		return new QuotationValidator();
	}

	@Override
	public Validator<? super Quotation> typeFormatValidator() {
		return new QuotationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super Quotation, Set<String>> onlyExistsValidator() {
		return new QuotationOnlyExistsValidator();
	}
}
