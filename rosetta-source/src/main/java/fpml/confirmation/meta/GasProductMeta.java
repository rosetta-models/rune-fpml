package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GasProduct;
import fpml.confirmation.validation.GasProductTypeFormatValidator;
import fpml.confirmation.validation.GasProductValidator;
import fpml.confirmation.validation.exists.GasProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GasProduct.class)
public class GasProductMeta implements RosettaMetaData<GasProduct> {

	@Override
	public List<Validator<? super GasProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.GasProduct>create(fpml.confirmation.validation.datarule.GasProductChoice.class)
		);
	}
	
	@Override
	public List<Function<? super GasProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GasProduct> validator() {
		return new GasProductValidator();
	}

	@Override
	public Validator<? super GasProduct> typeFormatValidator() {
		return new GasProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GasProduct, Set<String>> onlyExistsValidator() {
		return new GasProductOnlyExistsValidator();
	}
}
