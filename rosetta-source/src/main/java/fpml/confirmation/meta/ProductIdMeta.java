package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ProductId;
import fpml.confirmation.validation.ProductIdTypeFormatValidator;
import fpml.confirmation.validation.ProductIdValidator;
import fpml.confirmation.validation.exists.ProductIdOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ProductId.class)
public class ProductIdMeta implements RosettaMetaData<ProductId> {

	@Override
	public List<Validator<? super ProductId>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductId, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ProductId> validator() {
		return new ProductIdValidator();
	}

	@Override
	public Validator<? super ProductId> typeFormatValidator() {
		return new ProductIdTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductId, Set<String>> onlyExistsValidator() {
		return new ProductIdOnlyExistsValidator();
	}
}
