package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OilProductType;
import fpml.confirmation.validation.OilProductTypeTypeFormatValidator;
import fpml.confirmation.validation.OilProductTypeValidator;
import fpml.confirmation.validation.exists.OilProductTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OilProductType.class)
public class OilProductTypeMeta implements RosettaMetaData<OilProductType> {

	@Override
	public List<Validator<? super OilProductType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super OilProductType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OilProductType> validator() {
		return new OilProductTypeValidator();
	}

	@Override
	public Validator<? super OilProductType> typeFormatValidator() {
		return new OilProductTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OilProductType, Set<String>> onlyExistsValidator() {
		return new OilProductTypeOnlyExistsValidator();
	}
}
