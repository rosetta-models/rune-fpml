package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.TradeWrapper;
import fpml.confirmation.validation.TradeWrapperTypeFormatValidator;
import fpml.confirmation.validation.TradeWrapperValidator;
import fpml.confirmation.validation.exists.TradeWrapperOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version ${project.version}
 */
@RosettaMeta(model=TradeWrapper.class)
public class TradeWrapperMeta implements RosettaMetaData<TradeWrapper> {

	@Override
	public List<Validator<? super TradeWrapper>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super TradeWrapper, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super TradeWrapper> validator() {
		return new TradeWrapperValidator();
	}

	@Override
	public Validator<? super TradeWrapper> typeFormatValidator() {
		return new TradeWrapperTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super TradeWrapper, Set<String>> onlyExistsValidator() {
		return new TradeWrapperOnlyExistsValidator();
	}
}
