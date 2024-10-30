package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericEquityAttributesModel;
import fpml.confirmation.validation.GenericEquityAttributesModelTypeFormatValidator;
import fpml.confirmation.validation.GenericEquityAttributesModelValidator;
import fpml.confirmation.validation.exists.GenericEquityAttributesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GenericEquityAttributesModel.class)
public class GenericEquityAttributesModelMeta implements RosettaMetaData<GenericEquityAttributesModel> {

	@Override
	public List<Validator<? super GenericEquityAttributesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericEquityAttributesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericEquityAttributesModel> validator() {
		return new GenericEquityAttributesModelValidator();
	}

	@Override
	public Validator<? super GenericEquityAttributesModel> typeFormatValidator() {
		return new GenericEquityAttributesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericEquityAttributesModel, Set<String>> onlyExistsValidator() {
		return new GenericEquityAttributesModelOnlyExistsValidator();
	}
}
