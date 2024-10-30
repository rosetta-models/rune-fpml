package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.FxAccrualOption;
import fpml.confirmation.validation.FxAccrualOptionTypeFormatValidator;
import fpml.confirmation.validation.FxAccrualOptionValidator;
import fpml.confirmation.validation.exists.FxAccrualOptionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=FxAccrualOption.class)
public class FxAccrualOptionMeta implements RosettaMetaData<FxAccrualOption> {

	@Override
	public List<Validator<? super FxAccrualOption>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.FxAccrualOption>create(fpml.confirmation.validation.datarule.FxAccrualOptionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super FxAccrualOption, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super FxAccrualOption> validator() {
		return new FxAccrualOptionValidator();
	}

	@Override
	public Validator<? super FxAccrualOption> typeFormatValidator() {
		return new FxAccrualOptionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super FxAccrualOption, Set<String>> onlyExistsValidator() {
		return new FxAccrualOptionOnlyExistsValidator();
	}
}
