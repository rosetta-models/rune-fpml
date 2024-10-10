package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ProductComponentIdentifier;
import fpml.confirmation.validation.ProductComponentIdentifierTypeFormatValidator;
import fpml.confirmation.validation.ProductComponentIdentifierValidator;
import fpml.confirmation.validation.exists.ProductComponentIdentifierOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ProductComponentIdentifier.class)
public class ProductComponentIdentifierMeta implements RosettaMetaData<ProductComponentIdentifier> {

	@Override
	public List<Validator<? super ProductComponentIdentifier>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ProductComponentIdentifier, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ProductComponentIdentifier> validator() {
		return new ProductComponentIdentifierValidator();
	}

	@Override
	public Validator<? super ProductComponentIdentifier> typeFormatValidator() {
		return new ProductComponentIdentifierTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ProductComponentIdentifier, Set<String>> onlyExistsValidator() {
		return new ProductComponentIdentifierOnlyExistsValidator();
	}
}
