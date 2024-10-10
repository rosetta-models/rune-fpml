package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnSwapNotional;
import fpml.confirmation.validation.ReturnSwapNotionalTypeFormatValidator;
import fpml.confirmation.validation.ReturnSwapNotionalValidator;
import fpml.confirmation.validation.exists.ReturnSwapNotionalOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=ReturnSwapNotional.class)
public class ReturnSwapNotionalMeta implements RosettaMetaData<ReturnSwapNotional> {

	@Override
	public List<Validator<? super ReturnSwapNotional>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.ReturnSwapNotional>create(fpml.confirmation.validation.datarule.ReturnSwapNotionalChoice.class)
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapNotional, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnSwapNotional> validator() {
		return new ReturnSwapNotionalValidator();
	}

	@Override
	public Validator<? super ReturnSwapNotional> typeFormatValidator() {
		return new ReturnSwapNotionalTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapNotional, Set<String>> onlyExistsValidator() {
		return new ReturnSwapNotionalOnlyExistsValidator();
	}
}
