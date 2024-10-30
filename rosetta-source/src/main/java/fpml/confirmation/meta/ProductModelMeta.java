package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ProductModel;
import fpml.confirmation.validation.ProductModelTypeFormatValidator;
import fpml.confirmation.validation.ProductModelValidator;
import fpml.confirmation.validation.exists.ProductModelOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ProductModel.class)
public class ProductModelMeta implements RosettaMetaData<ProductModel> {

	@Override
	public List<Validator<? super ProductModel>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductModel, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ProductModel> validator() {
		return new ProductModelValidator();
	}

	@Override
	public Validator<? super ProductModel> typeFormatValidator() {
		return new ProductModelTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductModel, Set<String>> onlyExistsValidator() {
		return new ProductModelOnlyExistsValidator();
	}
}
