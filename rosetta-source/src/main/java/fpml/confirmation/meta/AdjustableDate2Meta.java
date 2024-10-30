package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.AdjustableDate2;
import fpml.confirmation.validation.AdjustableDate2TypeFormatValidator;
import fpml.confirmation.validation.AdjustableDate2Validator;
import fpml.confirmation.validation.exists.AdjustableDate2OnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=AdjustableDate2.class)
public class AdjustableDate2Meta implements RosettaMetaData<AdjustableDate2> {

	@Override
	public List<Validator<? super AdjustableDate2>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.AdjustableDate2>create(fpml.confirmation.validation.datarule.AdjustableDate2Choice.class)
		);
	}
	
	@Override
	public List<Function<? super AdjustableDate2, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super AdjustableDate2> validator() {
		return new AdjustableDate2Validator();
	}

	@Override
	public Validator<? super AdjustableDate2> typeFormatValidator() {
		return new AdjustableDate2TypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super AdjustableDate2, Set<String>> onlyExistsValidator() {
		return new AdjustableDate2OnlyExistsValidator();
	}
}
