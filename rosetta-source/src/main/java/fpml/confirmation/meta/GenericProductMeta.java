package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GenericProduct;
import fpml.confirmation.validation.GenericProductTypeFormatValidator;
import fpml.confirmation.validation.GenericProductValidator;
import fpml.confirmation.validation.exists.GenericProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=GenericProduct.class)
public class GenericProductMeta implements RosettaMetaData<GenericProduct> {

	@Override
	public List<Validator<? super GenericProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.GenericProduct>create(fpml.confirmation.validation.datarule.GenericProductChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GenericProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GenericProduct> validator() {
		return new GenericProductValidator();
	}

	@Override
	public Validator<? super GenericProduct> typeFormatValidator() {
		return new GenericProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GenericProduct, Set<String>> onlyExistsValidator() {
		return new GenericProductOnlyExistsValidator();
	}
}
