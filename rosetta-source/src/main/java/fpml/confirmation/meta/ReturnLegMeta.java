package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnLeg;
import fpml.confirmation.validation.ReturnLegTypeFormatValidator;
import fpml.confirmation.validation.ReturnLegValidator;
import fpml.confirmation.validation.exists.ReturnLegOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReturnLeg.class)
public class ReturnLegMeta implements RosettaMetaData<ReturnLeg> {

	@Override
	public List<Validator<? super ReturnLeg>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnLeg, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnLeg> validator() {
		return new ReturnLegValidator();
	}

	@Override
	public Validator<? super ReturnLeg> typeFormatValidator() {
		return new ReturnLegTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnLeg, Set<String>> onlyExistsValidator() {
		return new ReturnLegOnlyExistsValidator();
	}
}
