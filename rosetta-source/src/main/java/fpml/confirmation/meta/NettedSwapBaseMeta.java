package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.NettedSwapBase;
import fpml.confirmation.validation.NettedSwapBaseTypeFormatValidator;
import fpml.confirmation.validation.NettedSwapBaseValidator;
import fpml.confirmation.validation.exists.NettedSwapBaseOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=NettedSwapBase.class)
public class NettedSwapBaseMeta implements RosettaMetaData<NettedSwapBase> {

	@Override
	public List<Validator<? super NettedSwapBase>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super NettedSwapBase, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super NettedSwapBase> validator() {
		return new NettedSwapBaseValidator();
	}

	@Override
	public Validator<? super NettedSwapBase> typeFormatValidator() {
		return new NettedSwapBaseTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super NettedSwapBase, Set<String>> onlyExistsValidator() {
		return new NettedSwapBaseOnlyExistsValidator();
	}
}
