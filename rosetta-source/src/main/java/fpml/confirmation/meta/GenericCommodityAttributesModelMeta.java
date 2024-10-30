package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericCommodityAttributesModel;
import fpml.confirmation.validation.GenericCommodityAttributesModelTypeFormatValidator;
import fpml.confirmation.validation.GenericCommodityAttributesModelValidator;
import fpml.confirmation.validation.exists.GenericCommodityAttributesModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GenericCommodityAttributesModel.class)
public class GenericCommodityAttributesModelMeta implements RosettaMetaData<GenericCommodityAttributesModel> {

	@Override
	public List<Validator<? super GenericCommodityAttributesModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GenericCommodityAttributesModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericCommodityAttributesModel> validator() {
		return new GenericCommodityAttributesModelValidator();
	}

	@Override
	public Validator<? super GenericCommodityAttributesModel> typeFormatValidator() {
		return new GenericCommodityAttributesModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericCommodityAttributesModel, Set<String>> onlyExistsValidator() {
		return new GenericCommodityAttributesModelOnlyExistsValidator();
	}
}
