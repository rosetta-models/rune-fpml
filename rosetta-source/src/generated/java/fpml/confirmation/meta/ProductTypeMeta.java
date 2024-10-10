package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ProductType;
import fpml.confirmation.validation.ProductTypeTypeFormatValidator;
import fpml.confirmation.validation.ProductTypeValidator;
import fpml.confirmation.validation.exists.ProductTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ProductType.class)
public class ProductTypeMeta implements RosettaMetaData<ProductType> {

	@Override
	public List<Validator<? super ProductType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ProductType> validator() {
		return new ProductTypeValidator();
	}

	@Override
	public Validator<? super ProductType> typeFormatValidator() {
		return new ProductTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductType, Set<String>> onlyExistsValidator() {
		return new ProductTypeOnlyExistsValidator();
	}
}
