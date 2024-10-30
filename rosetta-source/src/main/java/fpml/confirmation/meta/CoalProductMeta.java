package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.CoalProduct;
import fpml.confirmation.validation.CoalProductTypeFormatValidator;
import fpml.confirmation.validation.CoalProductValidator;
import fpml.confirmation.validation.exists.CoalProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=CoalProduct.class)
public class CoalProductMeta implements RosettaMetaData<CoalProduct> {

	@Override
	public List<Validator<? super CoalProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.CoalProduct>create(fpml.confirmation.validation.datarule.CoalProductChoice.class)
		);
	}
	
	@Override
	public List<Function<? super CoalProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super CoalProduct> validator() {
		return new CoalProductValidator();
	}

	@Override
	public Validator<? super CoalProduct> typeFormatValidator() {
		return new CoalProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super CoalProduct, Set<String>> onlyExistsValidator() {
		return new CoalProductOnlyExistsValidator();
	}
}
