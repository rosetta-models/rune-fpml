package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.VarianceLeg;
import fpml.confirmation.validation.VarianceLegTypeFormatValidator;
import fpml.confirmation.validation.VarianceLegValidator;
import fpml.confirmation.validation.exists.VarianceLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=VarianceLeg.class)
public class VarianceLegMeta implements RosettaMetaData<VarianceLeg> {

	@Override
	public List<Validator<? super VarianceLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super VarianceLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super VarianceLeg> validator() {
		return new VarianceLegValidator();
	}

	@Override
	public Validator<? super VarianceLeg> typeFormatValidator() {
		return new VarianceLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super VarianceLeg, Set<String>> onlyExistsValidator() {
		return new VarianceLegOnlyExistsValidator();
	}
}
