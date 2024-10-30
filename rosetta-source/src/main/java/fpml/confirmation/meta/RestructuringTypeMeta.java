package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.RestructuringType;
import fpml.confirmation.validation.RestructuringTypeTypeFormatValidator;
import fpml.confirmation.validation.RestructuringTypeValidator;
import fpml.confirmation.validation.exists.RestructuringTypeOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=RestructuringType.class)
public class RestructuringTypeMeta implements RosettaMetaData<RestructuringType> {

	@Override
	public List<Validator<? super RestructuringType>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
		);
	}
	
	@Override
	public List<Function<? super RestructuringType, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super RestructuringType> validator() {
		return new RestructuringTypeValidator();
	}

	@Override
	public Validator<? super RestructuringType> typeFormatValidator() {
		return new RestructuringTypeTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super RestructuringType, Set<String>> onlyExistsValidator() {
		return new RestructuringTypeOnlyExistsValidator();
	}
}
