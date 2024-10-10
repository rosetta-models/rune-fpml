package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.BasicQuotation;
import fpml.confirmation.validation.BasicQuotationTypeFormatValidator;
import fpml.confirmation.validation.BasicQuotationValidator;
import fpml.confirmation.validation.exists.BasicQuotationOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=BasicQuotation.class)
public class BasicQuotationMeta implements RosettaMetaData<BasicQuotation> {

	@Override
	public List<Validator<? super BasicQuotation>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super BasicQuotation, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super BasicQuotation> validator() {
		return new BasicQuotationValidator();
	}

	@Override
	public Validator<? super BasicQuotation> typeFormatValidator() {
		return new BasicQuotationTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super BasicQuotation, Set<String>> onlyExistsValidator() {
		return new BasicQuotationOnlyExistsValidator();
	}
}
