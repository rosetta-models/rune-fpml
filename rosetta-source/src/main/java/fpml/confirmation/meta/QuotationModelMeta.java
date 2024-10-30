package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.QuotationModel;
import fpml.confirmation.validation.QuotationModelTypeFormatValidator;
import fpml.confirmation.validation.QuotationModelValidator;
import fpml.confirmation.validation.exists.QuotationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=QuotationModel.class)
public class QuotationModelMeta implements RosettaMetaData<QuotationModel> {

	@Override
	public List<Validator<? super QuotationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuotationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super QuotationModel> validator() {
		return new QuotationModelValidator();
	}

	@Override
	public Validator<? super QuotationModel> typeFormatValidator() {
		return new QuotationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuotationModel, Set<String>> onlyExistsValidator() {
		return new QuotationModelOnlyExistsValidator();
	}
}
