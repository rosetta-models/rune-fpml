package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.GrossCashflow;
import fpml.confirmation.validation.GrossCashflowTypeFormatValidator;
import fpml.confirmation.validation.GrossCashflowValidator;
import fpml.confirmation.validation.exists.GrossCashflowOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=GrossCashflow.class)
public class GrossCashflowMeta implements RosettaMetaData<GrossCashflow> {

	@Override
	public List<Validator<? super GrossCashflow>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super GrossCashflow, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super GrossCashflow> validator() {
		return new GrossCashflowValidator();
	}

	@Override
	public Validator<? super GrossCashflow> typeFormatValidator() {
		return new GrossCashflowTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super GrossCashflow, Set<String>> onlyExistsValidator() {
		return new GrossCashflowOnlyExistsValidator();
	}
}
