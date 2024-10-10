package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OilProduct;
import fpml.confirmation.validation.OilProductTypeFormatValidator;
import fpml.confirmation.validation.OilProductValidator;
import fpml.confirmation.validation.exists.OilProductOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=OilProduct.class)
public class OilProductMeta implements RosettaMetaData<OilProduct> {

	@Override
	public List<Validator<? super OilProduct>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OilProduct, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OilProduct> validator() {
		return new OilProductValidator();
	}

	@Override
	public Validator<? super OilProduct> typeFormatValidator() {
		return new OilProductTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilProduct, Set<String>> onlyExistsValidator() {
		return new OilProductOnlyExistsValidator();
	}
}
