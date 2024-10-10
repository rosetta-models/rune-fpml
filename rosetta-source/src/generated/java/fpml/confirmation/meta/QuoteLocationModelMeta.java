package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.QuoteLocationModel;
import fpml.confirmation.validation.QuoteLocationModelTypeFormatValidator;
import fpml.confirmation.validation.QuoteLocationModelValidator;
import fpml.confirmation.validation.exists.QuoteLocationModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=QuoteLocationModel.class)
public class QuoteLocationModelMeta implements RosettaMetaData<QuoteLocationModel> {

	@Override
	public List<Validator<? super QuoteLocationModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.QuoteLocationModel>create(fpml.confirmation.validation.datarule.QuoteLocationModelChoice.class)
		);
	}
	
	@Override
	public List<Function<? super QuoteLocationModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super QuoteLocationModel> validator() {
		return new QuoteLocationModelValidator();
	}

	@Override
	public Validator<? super QuoteLocationModel> typeFormatValidator() {
		return new QuoteLocationModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuoteLocationModel, Set<String>> onlyExistsValidator() {
		return new QuoteLocationModelOnlyExistsValidator();
	}
}
