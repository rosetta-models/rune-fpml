package fpml.confirmation.meta;

import com.rosetta.model.lib.annotations.RosettaMeta;
import com.rosetta.model.lib.meta.RosettaMetaData;
import com.rosetta.model.lib.qualify.QualifyFunctionFactory;
import com.rosetta.model.lib.qualify.QualifyResult;
import com.rosetta.model.lib.validation.Validator;
import com.rosetta.model.lib.validation.ValidatorFactory;
import com.rosetta.model.lib.validation.ValidatorWithArg;
import fpml.confirmation.OutstandingsPosition;
import fpml.confirmation.validation.OutstandingsPositionTypeFormatValidator;
import fpml.confirmation.validation.OutstandingsPositionValidator;
import fpml.confirmation.validation.exists.OutstandingsPositionOnlyExistsValidator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;


/**
 * @version 0.0.0.master-SNAPSHOT
 */
@RosettaMeta(model=OutstandingsPosition.class)
public class OutstandingsPositionMeta implements RosettaMetaData<OutstandingsPosition> {

	@Override
	public List<Validator<? super OutstandingsPosition>> dataRules(ValidatorFactory factory) {
		return Arrays.asList(
			factory.<fpml.confirmation.OutstandingsPosition>create(fpml.confirmation.validation.datarule.OutstandingsPositionChoice.class)
		);
	}
	
	@Override
	public List<Function<? super OutstandingsPosition, QualifyResult>> getQualifyFunctions(QualifyFunctionFactory factory) {
		return Collections.emptyList();
	}

	@Override
	public Validator<? super OutstandingsPosition> validator() {
		return new OutstandingsPositionValidator();
	}

	@Override
	public Validator<? super OutstandingsPosition> typeFormatValidator() {
		return new OutstandingsPositionTypeFormatValidator();
	}
	
	@Override
	public ValidatorWithArg<? super OutstandingsPosition, Set<String>> onlyExistsValidator() {
		return new OutstandingsPositionOnlyExistsValidator();
	}
}
