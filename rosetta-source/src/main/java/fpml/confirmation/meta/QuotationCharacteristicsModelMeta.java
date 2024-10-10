package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.QuotationCharacteristicsModel;
import fpml.confirmation.validation.QuotationCharacteristicsModelTypeFormatValidator;
import fpml.confirmation.validation.QuotationCharacteristicsModelValidator;
import fpml.confirmation.validation.exists.QuotationCharacteristicsModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=QuotationCharacteristicsModel.class)
public class QuotationCharacteristicsModelMeta implements RosettaMetaData<QuotationCharacteristicsModel> {

	@Override
	public List<Validator<? super QuotationCharacteristicsModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super QuotationCharacteristicsModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super QuotationCharacteristicsModel> validator() {
		return new QuotationCharacteristicsModelValidator();
	}

	@Override
	public Validator<? super QuotationCharacteristicsModel> typeFormatValidator() {
		return new QuotationCharacteristicsModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super QuotationCharacteristicsModel, Set<String>> onlyExistsValidator() {
		return new QuotationCharacteristicsModelOnlyExistsValidator();
	}
}
