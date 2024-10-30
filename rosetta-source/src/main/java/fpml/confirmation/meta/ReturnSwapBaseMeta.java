package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.ReturnSwapBase;
import fpml.confirmation.validation.ReturnSwapBaseTypeFormatValidator;
import fpml.confirmation.validation.ReturnSwapBaseValidator;
import fpml.confirmation.validation.exists.ReturnSwapBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=ReturnSwapBase.class)
public class ReturnSwapBaseMeta implements RosettaMetaData<ReturnSwapBase> {

	@Override
	public List<Validator<? super ReturnSwapBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super ReturnSwapBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super ReturnSwapBase> validator() {
		return new ReturnSwapBaseValidator();
	}

	@Override
	public Validator<? super ReturnSwapBase> typeFormatValidator() {
		return new ReturnSwapBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super ReturnSwapBase, Set<String>> onlyExistsValidator() {
		return new ReturnSwapBaseOnlyExistsValidator();
	}
}
